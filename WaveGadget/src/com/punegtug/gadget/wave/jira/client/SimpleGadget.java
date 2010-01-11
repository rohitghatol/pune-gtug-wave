package com.punegtug.gadget.wave.jira.client;

import org.cobogw.gwt.waveapi.gadget.client.ParticipantUpdateEvent;
import org.cobogw.gwt.waveapi.gadget.client.ParticipantUpdateEventHandler;
import org.cobogw.gwt.waveapi.gadget.client.StateUpdateEvent;
import org.cobogw.gwt.waveapi.gadget.client.StateUpdateEventHandler;
import org.cobogw.gwt.waveapi.gadget.client.WaveGadget;

import com.google.gwt.gadgets.client.DynamicHeightFeature;
import com.google.gwt.gadgets.client.NeedsDynamicHeight;
import com.google.gwt.gadgets.client.Gadget.ModulePrefs;
import com.google.gwt.user.client.ui.RootPanel;
import com.punegtug.gadget.wave.jira.client.settings.SettingsPanelModel;
import com.punegtug.gadget.wave.jira.client.settings.SettingsPanelView;
import com.punegtug.gadget.wave.jira.client.settings.WaveGadgetUserPreference;

@ModulePrefs(title = "SimpleGadget", author = "Rohit Ghatol", author_email = "rohitsghatol@gmail.com")
public class SimpleGadget extends WaveGadget<WaveGadgetUserPreference> implements NeedsDynamicHeight
{

	private DynamicHeightFeature dynamicHeightFeature = null;


	public SimpleGadget()
	{

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
	protected void init(final WaveGadgetUserPreference preferences)
	{
		final SettingsPanelModel model = new SettingsPanelModel();
		model.setValues(preferences);
		final SettingsPanelView settings = new SettingsPanelView(model);
		RootPanel.get().add(settings);
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
