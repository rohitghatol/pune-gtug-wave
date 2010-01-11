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

package com.punegtug.gadget.wave.poll.client.model;

import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.charts.client.model.ToolTip;
import com.extjs.gxt.charts.client.model.ToolTip.MouseStyle;
import com.extjs.gxt.charts.client.model.axis.XAxis;
import com.extjs.gxt.charts.client.model.axis.YAxis;
import com.extjs.gxt.charts.client.model.charts.HorizontalBarChart;
import com.google.gwt.user.client.Random;
import com.punegtug.gadget.wave.poll.client.mvc.Observable;

/**
 * @author rohitghatol
 * 
 */
public class PollModel extends Observable
{
	private ChartModel chartModel = null;


	public PollModel()
	{

		chartModel = new ChartModel("Voted Best AJAX Framework",
				"font-size: 14px; font-family: Verdana; text-align: center;");
		final XAxis xa = new XAxis();
		xa.setRange(0, 200, 50);
		chartModel.setXAxis(xa);
		final YAxis ya = new YAxis();
		ya.addLabels("Ext", "Dojo", "jQuery", "YUI");
		ya.setOffset(true);
		chartModel.setYAxis(ya);
		final HorizontalBarChart bchart = new HorizontalBarChart();
		bchart.setTooltip("#val# mph");
		bchart.addBars(new HorizontalBarChart.Bar(Random.nextInt(47) + 100, "#ffff00"));
		bchart.addBars(new HorizontalBarChart.Bar(Random.nextInt(44) + 100, "#0000ff"));
		bchart.addBars(new HorizontalBarChart.Bar(Random.nextInt(23) + 100, "#00ff00"));
		bchart.addBars(new HorizontalBarChart.Bar(Random.nextInt(50) + 150, "#ff0000"));
		chartModel.addChartConfig(bchart);
		chartModel.setTooltipStyle(new ToolTip(MouseStyle.FOLLOW));

	}


	public ChartModel getChartModel()
	{
		return chartModel;
	}

}
