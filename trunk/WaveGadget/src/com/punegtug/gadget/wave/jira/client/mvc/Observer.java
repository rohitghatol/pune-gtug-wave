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

/**
 * Observer interface which register themselves with an Observable and get notified when Observable fires notify
 * 
 * @author rohitghatol
 * 
 */
public interface Observer
{

	/**
	 * Calls on the observers to update themselve with the given Model
	 * 
	 * @param model
	 */
	void update(Observable model);
}
