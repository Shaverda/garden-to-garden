package com.garden2garden.httpserver.handlers;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

import com.garden2garden.events.AccountInfo;
import com.garden2garden.persistence.PersistenceProvider;

/**
 * Created by Josh on 6/4/2017.
 */
public class GetAccountHandler extends AbstractVerticle
{
	public static final String ADDRESS = "com.garden2garden.httpserver.handlers.getAccountHandler";

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
		vertx.eventBus().<String>consumer(ADDRESS, msg ->
		{
			String email = msg.body();
			getAccountInfo(email).thenAccept(msg::reply);
		});
	}

	/**
	 * Fetches account info via email
	 *
	 * @param email
	 * @return A CompletableFuture containing a string representing the {@link JsonObject} representing the {@link AccountInfo}.
	 * 		   Can be transformed again via
	 */
	private CompletableFuture<String> getAccountInfo(String email)
	{
		CompletableFuture<String> future = new CompletableFuture<>();
		vertx.eventBus().<String>send(PersistenceProvider.FETCH_ACCOUNT, UUID.nameUUIDFromBytes(email.getBytes()).toString(), result ->
		{
			if (result.succeeded())
			{
				future.complete(result.result().body());
			}
			else
			{
				throw new RuntimeException("Error in GetAccountHandler::getAccountInfo, results from Peristence verticle was unsuccessful: "
					+ result.cause());
			}
		});

		return future;
	}
}
