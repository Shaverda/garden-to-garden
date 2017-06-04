package com.garden2garden.httpserver;

import java.util.UUID;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

import com.garden2garden.httpserver.handlers.CreateAccountHandler;
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

		vertx.deployVerticle(new CreateAccountHandler(), res ->
		{
			startFuture.complete();
		});

//		startFuture.complete();
	}

	private void generateRoutes()
	{
		EventBus eventBus = vertx.eventBus();

		// Account Creation
		router.post("/accounts/create").handler(requestContext ->
		{
			// TODO: Handle account creation
			// This should be handled by adding an event to the eventbus and letting a different verticle handle it async
			eventBus.<Buffer>send(CreateAccountHandler.ADDRESS, requestContext.getBody(), result ->
			{
				if (result.succeeded())
				{
					Logger.info("New UUID after being serialized over the eventbus: " + result.result().body().toJsonObject().mapTo(UUID.class));

					JsonObject responseBody = new JsonObject();
					responseBody.put("userId", result.result().body().toJsonObject().mapTo(UUID.class));
					HttpServerResponse response = requestContext.response();
					response.putHeader("content-type", "text/plain");
					response.end(responseBody.toString());
				}
				else
				{

				}
			});
		});

		// Search Query
		router.get("/query/:queryId").handler(request ->
		{

		});
	}
}
