/**
 * Copyright Quickoffice, Inc, 2005-2009
 * 
 * NOTICE: The intellectual and technical concepts contained herein are proprietary to Quickoffice, Inc. and is
 * protected by trade secret and copyright law. Dissemination of any of this information or reproduction of this
 * material is strictly forbidden unless prior written permission is obtained from Quickoffice, Inc.
 * 
 * Created: Jan 9, 2010 Author: rohitghatol
 * 
 */

package com.punegtug.gadget.wave.jira.client.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rohitghatol
 * 
 */
public abstract class Observable
{
	/**
	 * List of observers interested in this Obervable
	 */
	private final List<Observer> observers = new ArrayList<Observer>();


	/**
	 * Registers itself with the given Observable for events
	 * 
	 * @param model
	 */
	public void register(final Observer observer)
	{
		observers.add(observer);
	}


	/**
	 * Unregisters itself with the given Observable for events;
	 * 
	 * @param model
	 */
	public void unregister(final Observer observer)
	{
		observers.remove(observer);
	}


	/**
	 * Notifies all the observers that this observable has changed
	 */
	public void notifyObservers()
	{
		for ( final Observer observer : observers )
		{
			observer.update(this);
		}
	}

}
