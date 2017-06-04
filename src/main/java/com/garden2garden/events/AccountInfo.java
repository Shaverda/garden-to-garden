package com.garden2garden.events;

import java.util.UUID;

/**
 * Ugh why is this and CreateAccountRequest separate whatever NO TIME
 */
public class AccountInfo
{
	public static AccountInfo accountInfoFromRequest(UUID accountId, CreateAccountRequest accountRequest)
	{
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.accountId = accountId;
		accountInfo.email = accountRequest.getEmail();
		accountInfo.location = accountRequest.getLocation();
		accountInfo.password = accountRequest.getPassword();
		accountInfo.accountName = accountRequest.getAccountName();

		return accountInfo;
	}

	private String accountName;
	private String email;
	private String location; //TODO This will change
	private String password;
	private UUID accountId;

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public UUID getAccountId()
	{
		return accountId;
	}

	public void setAccountId(UUID accountId)
	{
		this.accountId = accountId;
	}
}
