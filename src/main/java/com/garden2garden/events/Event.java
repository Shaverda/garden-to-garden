package com.garden2garden.events;

/**
 * TODO: This event framework that gives vertx eventbus actual, type safe event types, instead of stupid typeless addresses and generics for messages
 * TODO: Will probably require that eventbus codec we found that supported all complex objects...
 */
public interface Event
{
	/**
	 * Provide the {@link io.vertx.core.eventbus.EventBus} address this event will be sent to
	 *
	 * @return Address this event will be broadcast to
	 */
	String getAddress();


}
