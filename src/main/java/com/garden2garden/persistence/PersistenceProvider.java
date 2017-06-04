package com.garden2garden.persistence;

import com.garden2garden.persistence.filebased.JsonFilePersistenceVerticle;

/**
 * Created by Josh on 6/4/2017.
 */
public class PersistenceProvider
{
	private static final String ADDRESS = "com.garden2garden.persistence.layer.address";
	public static final String CREATE_ACCOUNT = ADDRESS + ".createAccount";
	public static final String FETCH_ACCOUNT = ADDRESS + ".fetchAccount";

	private static IPersistenceLayer persistenceLayer = new JsonFilePersistenceVerticle();

	/**
	 * Lol not using this atm but idea is make the methods on IPeristenceLayer static, and have them just send the messages
	 * to the instance of their own verticle on the eventbus, and return a promise
	 *
	 * @return
	 */
	public static IPersistenceLayer getPersistenceLayer()
	{
		return persistenceLayer;
	}
}
