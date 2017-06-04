package com.garden2garden.httpserver.handlers;

import java.util.UUID;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import com.garden2garden.events.CreateAccountRequest;
import com.garden2garden.httpserver.exceptions.InvalidRequestException;
import com.garden2garden.util.Logger;

/**
 * Created by Josh on 6/3/2017.
 */
public class CreateAccountHandler extends AbstractVerticle
{
	public static final String ADDRESS = "account.create";

	/**
	 * If your verticle does a simple, synchronous start-up then override this method and put your start-up
	 * code in there.
	 *
	 * @throws Exception
	 */
	@Override
	public void start() throws Exception
	{
		vertx.eventBus().consumer(ADDRESS, this::requestHandler);
	}

	private void requestHandler(Message<Buffer> msg)
	{
		CreateAccountRequest request = msg.body().toJsonObject().mapTo(CreateAccountRequest.class);

		try
		{
			validate(request);
		}
		catch (InvalidRequestException e)
		{
			e.printStackTrace();
			msg.reply("Failure"); // TODO: this
		}

		msg.reply(createAccount(request).toString());
	}

	/**
	 * TODO: This entire method
	 *
	 * @param request
	 * @throws InvalidRequestException
	 */
	private void validate(CreateAccountRequest request) throws InvalidRequestException
	{

	}

	/**
	 * TODO: Most of this method.
	 *
	 * @param request
	 * @return UUID Representing the newly created account
	 */
	private UUID createAccount(CreateAccountRequest request)
	{
		UUID accountUUID = generateUUIDFromEmail(request);
		Logger.log("Created new UUID for email: " + request.getEmail() + " : " + accountUUID);

		// TODO: Create account in backend

		return accountUUID;
	}

	private UUID generateUUIDFromEmail(CreateAccountRequest request)
	{
		return UUID.nameUUIDFromBytes(request.getEmail().getBytes());
	}
}
