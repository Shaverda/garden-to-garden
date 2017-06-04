package com.garden2garden.events;

import io.vertx.core.eventbus.MessageConsumer;

/**
 * TODO: This class. Going to hack it for now, would be nice to finish this framework sometime
 */
public interface EventHandler
{
	/**
	 * Register this listener
	 * @param address
	 */
	void register(Event event);


	<T> MessageConsumer<T> handler(T message);
}
