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

import com.google.gwt.gadgets.client.StringPreference;
import com.google.gwt.gadgets.client.UserPreferences;
import com.google.gwt.gadgets.client.UserPreferences.PreferenceAttributes.Options;

/**
 * @author rohitghatol
 * 
 */
public interface WaveGadgetUserPreference extends UserPreferences
{
	@PreferenceAttributes(display_name = "Jira URL", //
	options = Options.REQUIRED)
	StringPreference jiraURL();


	@PreferenceAttributes(display_name = "Jira Prefixes", //
	options = Options.REQUIRED)
	StringPreference jiraPrefixes();


	@PreferenceAttributes(display_name = "Jira Id", //
	options = Options.REQUIRED)
	StringPreference jiraId();


	@PreferenceAttributes(display_name = "User Name", //
	options = Options.REQUIRED)
	StringPreference jiraUserName();


	@PreferenceAttributes(display_name = "Password", //
	options = Options.REQUIRED)
	StringPreference jiraPassword();

}
