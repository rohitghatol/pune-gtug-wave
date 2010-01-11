package com.punegtug.gadget.wave.jira.server;

import com.punegtug.gadget.wave.jira.client.Service;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/*
 * * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ServiceImpl extends RemoteServiceServlet implements Service
{

	public String greetServer(String input)
	{
		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");
		return "Hello, " + input + "!<br><br>I am running " + serverInfo + ".<br><br>It looks like you are using:<br>"
				+ userAgent;
	}
}
