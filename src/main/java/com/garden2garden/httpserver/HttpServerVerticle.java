package com.garden2garden.httpserver;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import com.garden2garden.httpserver.handlers.CreateAccountHandler;
import com.garden2garden.httpserver.handlers.GetAccountHandler;
import com.garden2garden.persistence.PersistenceProvider;
import com.garden2garden.util.Logger;

/**
 * Created by Josh on 6/3/2017.
 */
public class HttpServerVerticle extends AbstractVerticle
{
	private static int PORT = 8080;

	/**
	 * Http server
	 */
	private HttpServer httpServer;

	private Router router;

	/**
	 * Start the verticle.<p>
	 * This is called by Vert.x when the verticle instance is deployed. Don't call it yourself.<p>
	 * If your verticle does things in it's startup which take some time then you can override this method
	 * and call the startFuture some time later when start up is complete.
	 *
	 * @param startFuture a future which should be called when verticle start-up is complete.
	 * @throws Exception
	 */
	@Override
	public void start(Future<Void> startFuture) throws Exception
	{
		Logger.debug("Inside start method of http server verticle");
		httpServer = vertx.createHttpServer();
		router = Router.router(vertx);

		generateRoutes();

		httpServer.requestHandler(router::accept).listen(PORT, res ->
		{
			if (res.succeeded())
			{
				Logger.info("Server startup success, listening port " + PORT);
			}
		});

		vertx.deployVerticle(new CreateAccountHandler());

		vertx.deployVerticle(PersistenceProvider.getPersistenceLayer());

		vertx.deployVerticle(new GetAccountHandler());

		startFuture.complete();
	}

	private void generateRoutes()
	{
		EventBus eventBus = vertx.eventBus();

		router.route().handler(BodyHandler.create());

		// Account Creation
		router.post("/accounts/create").handler(requestContext ->
		{
			// TODO: Handle account creation
			// This should be handled by adding an event to the eventbus and letting a different verticle handle it async
			eventBus.<String>send(CreateAccountHandler.ADDRESS, requestContext.getBody(), result ->
			{
				if (result.succeeded())
				{
					Logger.info("New UUID after being serialized over the eventbus: " + UUID.fromString(result.result().body()));

					JsonObject responseBody = new JsonObject();
					responseBody.put("userId", result.result().body());
					HttpServerResponse response = requestContext.response();
					response.putHeader("content-type", "application/json");
					response.end(responseBody.toString());
				}
				else
				{

				}
			});
		});

		router.get("/accounts/:email").handler(requestContext ->
		{
			String email = requestContext.request().getParam("email");
			Logger.info("Received request for account info for email: " + email);
			eventBus.<String>send(GetAccountHandler.ADDRESS, requestContext.request().getParam("email"), result ->
			{
				if (result.succeeded())
				{
					Logger.info("Fetched Account Info for email: " + email + " : " + result.result().body());

					JsonObject responseBody = new JsonObject();
					responseBody.put("accountInfo", new JsonObject(result.result().body()));

					HttpServerResponse response = requestContext.response();
					response.putHeader("content-type", "application/json");
					response.end(responseBody.toString());
				}
				else
				{
					Logger.error("Failed to fetch account: " + email + " : " + result.cause());
					requestContext.response().setStatusCode(500).end();
				}
			});
		});

		// Search Query
		router.get("/query/:queryId").handler(requestContext ->
		{

		});
	}
}
