package com.qualityhouse.course.altae.datadriventesting.support;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public class User
{
    private String username;
    private String password;
    private String email;
    private String name;
    private String phone;
    private String address;

    public User( )
    {
        super( );
    }

    public User( String username,
                 String password )
    {
        super( );
        setUsername( username );
        setPassword( password );
    }

    public User( String username,
                 String password,
                 String name,
                 String email,
                 String phone,
                 String address )
    {
        this( username,
              password );
        setName( name );
        setEmail( email );
        setPhone( phone );
        setAddress( address );
    }

    public String getUsername( )
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public String getPassword( )
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getEmail( )
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getName( )
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getPhone( )
    {
        return phone;
    }

    public void setPhone( String phone )
    {
        this.phone = phone;
    }

    public String getAddress( )
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }

    @Override
    public String toString( )
    {
        StringBuilder sb = new StringBuilder( );
        sb.append( "User: " )
          .append( this.name )
          .append( " username: " )
          .append( this.username )
          .append( " password: " )
          .append( this.password )
          .append( " email:" )
          .append( this.email );
        return sb.toString( );
    }
}
