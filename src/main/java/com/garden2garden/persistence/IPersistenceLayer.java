package com.garden2garden.persistence;

import java.util.UUID;
import io.vertx.core.Verticle;

import com.garden2garden.events.AccountInfo;

/**
 * So freaking bad but we have 3 hours left goooooooooooooooooooo
 */
public interface IPersistenceLayer extends Verticle
{
	/**
	 * Should be static, and just send an eventbus message to the real methods, and return a promise
	 * @param accountInfo
	 */
	void writeAccount(AccountInfo accountInfo);

	/**
	 * Should be static, and just send an eventbus message to the real methods, and return a promise
	 * @param accountId
	 */
	AccountInfo getAccount(UUID accountId);
}
