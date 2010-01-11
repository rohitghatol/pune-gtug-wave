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

import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.layout.FitData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.punegtug.gadget.wave.poll.client.model.PollModel;
import com.punegtug.gadget.wave.poll.client.mvc.Observable;
import com.punegtug.gadget.wave.poll.client.mvc.Observer;

/**
 * @author rohitghatol
 * 
 */
public class PollResultView extends FieldSet implements Observer
{
	private final PollModel model = null;


	public static boolean isExplorer()
	{
		final String test = Window.Location.getPath();
		if ( test.indexOf("pages") != -1 )
		{
			return false;
		}
		return true;
	}


	public PollResultView(final PollModel model)
	{
		setHeading("Poll Result");
		setLayout(new FitLayout());

		final String url = "http://jirawave.appspot.com/resources/chart/open-flash-chart.swf";

		final Chart chart = new Chart(url);
		chart.setBorders(true);
		this.add(chart, new FitData(0, 0, 20, 0));
		final Command updateCmd = new Command() {
			public void execute()
			{
				chart.setChartModel(model.getChartModel());
			}
		};
		updateCmd.execute();
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
