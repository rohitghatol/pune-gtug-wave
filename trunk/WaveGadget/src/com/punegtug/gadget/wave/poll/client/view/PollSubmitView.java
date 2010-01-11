/**
 * Copyright Quickoffice, Inc, 2005-2009
 * 
 * NOTICE: The intellectual and technical concepts contained herein are proprietary to Quickoffice, Inc. and is
 * protected by trade secret and copyright law. Dissemination of any of this information or reproduction of this
 * material is strictly forbidden unless prior written permission is obtained from Quickoffice, Inc.
 * 
 * Created: Jan 11, 2010 Author: rohitghatol
 * 
 */

package com.punegtug.gadget.wave.poll.client.view;

import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.punegtug.gadget.wave.poll.client.model.PollModel;
import com.punegtug.gadget.wave.poll.client.mvc.Observable;
import com.punegtug.gadget.wave.poll.client.mvc.Observer;

/**
 * @author rohitghatol
 * 
 */
public class PollSubmitView extends FieldSet implements Observer
{

	private PollModel model = null;


	public PollSubmitView(final PollModel model)
	{
		this.model = model;
	}


	/*
	 * (non-Javadoc)
	 * @see com.punegtug.gadget.wave.poll.client.mvc.Observer#update(com.punegtug.gadget.wave.poll.client.mvc.Observable)
	 */
	@Override
	public void update(final Observable model)
	{
		// TODO Auto-generated method stub

	}

}
