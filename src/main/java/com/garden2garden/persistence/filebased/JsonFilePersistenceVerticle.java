package com.garden2garden.persistence.filebased;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;

import com.garden2garden.events.AccountInfo;
import com.garden2garden.persistence.IPersistenceLayer;
import com.garden2garden.persistence.PersistenceProvider;

/**
 * Created by Josh on 6/4/2017.
 */
public class JsonFilePersistenceVerticle extends AbstractVerticle implements IPersistenceLayer
{
	private static final String FILE_PATH = "accountStore.json";

	/**
	 * Have to use Object because vertx is fucking stupid. It's not like jackson can't handle this shit. But in a hurry so whatevs.
	 */
	private Map<String, Object> accountInfoMap = new HashMap<>();


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
		if (vertx.fileSystem().existsBlocking(FILE_PATH))
		{
			accountInfoMap = vertx.fileSystem().readFileBlocking(FILE_PATH).toJsonObject().getMap();
		}
		else
		{
			vertx.fileSystem().createFileBlocking(FILE_PATH); // PERMISSIONS???
		}

		vertx.eventBus().<String>consumer(PersistenceProvider.CREATE_ACCOUNT, msg ->
		{
			AccountInfo accountInfo = new JsonObject(msg.body()).mapTo(AccountInfo.class);
			writeAccount(accountInfo);

			msg.reply(null);
		});

		vertx.eventBus().<String>consumer(PersistenceProvider.FETCH_ACCOUNT, msg ->
		{
			AccountInfo accountInfo = getAccount(UUID.fromString(msg.body()));
			msg.reply(JsonObject.mapFrom(accountInfo));
		});
	}

	@Override
	public AccountInfo getAccount(UUID accountId)
	{
		//ugh
		return (AccountInfo) accountInfoMap.get(accountId.toString());
	}

	@Override
	public void writeAccount(AccountInfo accountInfo)
	{
		accountInfoMap.put(accountInfo.getAccountId().toString(), accountInfo);

		//new JsonObject(accountInfoMap); This doesn't work because vertx is fucking stupid, and they try to drag their js no type bullshit everywhere
		JsonObject entries = new JsonObject(accountInfoMap);

		vertx.fileSystem().writeFileBlocking(FILE_PATH, Buffer.buffer(entries.encodePrettily()));
	}
}
