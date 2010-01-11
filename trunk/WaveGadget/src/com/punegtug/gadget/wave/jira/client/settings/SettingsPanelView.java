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

package com.punegtug.gadget.wave.jira.client.settings;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.punegtug.gadget.wave.jira.client.mvc.Observable;
import com.punegtug.gadget.wave.jira.client.mvc.Observer;

/**
 * @author rohitghatol
 * 
 */
public class SettingsPanelView extends LayoutContainer implements Observer
{
	private final VerticalPanel vp;
	private final FormData formData;
	private SettingsPanelModel model = null;
	private final TextField jiraUrl = new TextField<String>();
	private final TextField prefixes = new TextField<String>();
	private final TextField jiraId = new TextField<String>();
	private final TextField<String> userName = new TextField<String>();
	private final TextField<String> password = new TextField<String>();
	private final FieldSet jiraFieldSet = new FieldSet();


	public SettingsPanelView(final SettingsPanelModel model)
	{
		this.model = model;
		vp = new VerticalPanel();
		vp.setSpacing(10);
		add(vp);
		formData = new FormData("-20");
		final FormPanel form2 = new FormPanel();
		form2.setFrame(true);
		form2.setHeading("Jira Gadget Settings");
		form2.setWidth(350);
		form2.setLayout(new FlowLayout());

		jiraFieldSet.setHeading("Jira Server Information");

		FormLayout layout = new FormLayout();
		layout.setLabelWidth(75);
		jiraFieldSet.setLayout(layout);

		jiraUrl.setFieldLabel("Jira Url");
		jiraUrl.setAllowBlank(false);
		jiraFieldSet.add(jiraUrl, formData);

		prefixes.setFieldLabel("Jira Prefixes (Comma Separated):");
		prefixes.setAllowBlank(false);
		jiraFieldSet.add(prefixes, formData);

		jiraId.setFieldLabel("Jira Id:");
		jiraId.setAllowBlank(false);
		jiraFieldSet.add(jiraId, formData);

		form2.add(jiraFieldSet);

		final FieldSet fieldSet = new FieldSet();
		fieldSet.setHeading("User Credentials");

		layout = new FormLayout();
		layout.setLabelWidth(75);
		fieldSet.setLayout(layout);

		userName.setFieldLabel("User Name");
		fieldSet.add(userName, formData);

		password.setFieldLabel("Password");
		password.setPassword(true);
		fieldSet.add(password, formData);

		form2.add(fieldSet);
		form2.setButtonAlign(HorizontalAlignment.CENTER);
		final Button saveButton = new Button("Save");
		final Button cancelButton = new Button("Cancel");
		saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(final ButtonEvent ce)
			{
				model.setJiraId(String.valueOf(jiraId.getValue()));
				model.setJiraURL(String.valueOf(jiraUrl.getValue()));

				model.setPrefixes(String.valueOf(prefixes.getValue()).split(","));
				model.setUserName(String.valueOf(userName.getValue()));
				model.setPassword(String.valueOf(password.getValue()));
				model.notifyObservers();

			}
		});
		cancelButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(final ButtonEvent ce)
			{
				render(model);

			}
		});
		form2.addButton(saveButton);
		form2.addButton(cancelButton);
		vp.removeAll();
		vp.add(form2);
		render(model);
	}


	private void render(final SettingsPanelModel model)
	{
		jiraFieldSet.setVisible(model.isCompleteMode());
		jiraUrl.setValue(model.getJiraURL().toString());
		final StringBuffer strBuff = new StringBuffer();
		for ( final String prefix : model.getPrefixes() )
		{
			strBuff.append(prefix).append(",");
		}
		prefixes.setValue(strBuff.toString());
		jiraId.setValue(model.getJiraId());
		userName.setValue(model.getUserName());
		password.setValue(model.getPassword());
	}


	/*
	 * (non-Javadoc)
	 * @see com.punegtug.gadget.wave.client.mvc.Observer#update(com.punegtug.gadget.wave.client.mvc.Observable)
	 */
	@Override
	public void update(final Observable model)
	{
		this.model = (SettingsPanelModel)model;
		render(this.model);

	}

}
