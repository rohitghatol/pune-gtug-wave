package com.punegtug.gadget.wave.poll.client;

import org.cobogw.gwt.waveapi.gadget.client.ParticipantUpdateEvent;
import org.cobogw.gwt.waveapi.gadget.client.ParticipantUpdateEventHandler;
import org.cobogw.gwt.waveapi.gadget.client.StateUpdateEvent;
import org.cobogw.gwt.waveapi.gadget.client.StateUpdateEventHandler;
import org.cobogw.gwt.waveapi.gadget.client.WaveGadget;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.gadgets.client.DynamicHeightFeature;
import com.google.gwt.gadgets.client.NeedsDynamicHeight;
import com.google.gwt.gadgets.client.UserPreferences;
import com.google.gwt.gadgets.client.Gadget.ModulePrefs;
import com.google.gwt.user.client.ui.RootPanel;
import com.punegtug.gadget.wave.poll.client.model.PollModel;
import com.punegtug.gadget.wave.poll.client.view.PollResultView;
import com.punegtug.gadget.wave.poll.client.view.PollSubmitView;

@ModulePrefs(title = "PollGadget", author = "Rohit Ghatol", author_email = "rohitsghatol@gmail.com")
public class PollGadget extends WaveGadget<UserPreferences> implements NeedsDynamicHeight
{

	private DynamicHeightFeature dynamicHeightFeature = null;

	private PollModel model = null;
	private PollResultView resultView = null;
	private PollSubmitView submitView = null;


	public PollGadget()
	{
		model = new PollModel();
		resultView = new PollResultView(model);
		submitView = new PollSubmitView(model);
	}


	/*
	 * (non-Javadoc)
	 * @see
	 * com.google.gwt.gadgets.client.NeedsDynamicHeight#initializeFeature(com.google.gwt.gadgets.client.DynamicHeightFeature
	 * )
	 */
	@Override
	public void initializeFeature(final DynamicHeightFeature dynamicHeightFeature)
	{
		this.dynamicHeightFeature = dynamicHeightFeature;

	}


	@Override
	protected void init(final UserPreferences preferences)
	{
		final ContentPanel cp = new ContentPanel();
		cp.setHeading("Charts Gallery");
		cp.setFrame(true);
		cp.setSize(700, 350);
		cp.setLayout(new BorderLayout());

		final BorderLayoutData eastData = new BorderLayoutData(LayoutRegion.EAST, 370);

		final BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
		centerData.setMargins(new Margins(0, 5, 0, 0));

		cp.add(submitView, centerData);
		cp.add(resultView, eastData);

		RootPanel.get().add(cp);
		dynamicHeightFeature.adjustHeight();
		getWave().addParticipantUpdateEventHandler(new ParticipantUpdateEventHandler() {
			public void onUpdate(final ParticipantUpdateEvent event)
			{
				// handle participants added, also called when wave with gadget is opened.
			}
		});
		getWave().addStateUpdateEventHandler(new StateUpdateEventHandler() {
			public void onUpdate(final StateUpdateEvent event)
			{
				// handle state changes.
			}
		});
	}

}
