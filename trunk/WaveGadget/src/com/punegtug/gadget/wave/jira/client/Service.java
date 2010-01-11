package com.punegtug.gadget.wave.jira.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/*
 * * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface Service extends RemoteService
{
	String greetServer(String name);
}
