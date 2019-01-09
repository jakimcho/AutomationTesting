package com.qualityhouse.course.altae.datadriventesting.data_providers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qualityhouse.course.altae.datadriventesting.support.User;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserDataProviders
{
    private static Logger LOGGER = Logger.getLogger( UserDataProviders.class );
    private static final ObjectMapper objectMapper = new ObjectMapper( );
    private static final String VALID_LOGINS_FILE = "data/valid-logins.json";
    private static final String INVALID_LOGINS_FILE = "data/invalid-logins.json";
    private static final String VALID_PROFILES_FILE = "data/valid-profiles.json";
    private static final String INVALID_PROFILES_FILE = "data/invalid-profiles.json";

    @DataProvider( name = "validLogins" )
    public static Object[][] getValidLogins( )
    {
        LOGGER.info( "Inside  getValidLogins method" );
        return getUsersFromJSONFile( VALID_LOGINS_FILE );
    }

    @DataProvider( name = "invalidLogins" )
    public static Object[][] getInvalidLogins( )
    {
        LOGGER.info( "Inside  getInvalidLogins method" );
        return getUsersFromJSONFile( INVALID_LOGINS_FILE );
    }

    @DataProvider( name = "validProfiles" )
    public static Object[][] getValidProfiles( )
    {
        LOGGER.info( "Inside  getValidProfiles method" );
        return getUsersFromJSONFile( VALID_PROFILES_FILE );
    }

    @DataProvider( name = "invalidProfiles" )
    public static Object[][] getInvalidProfiles( )
    {
        LOGGER.info( "Inside  getInvalidProfiles method" );
        return getUsersFromJSONFile( INVALID_PROFILES_FILE );
    }

    private static Object[][] getUsersFromJSONFile( String fileName )
    {
        Object[][] loginsData = null;
        try
        {
            LOGGER.info( "Trying to get data from file:" + fileName );
            File validUsersFile = new File( fileName );
            TypeReference tr = new TypeReference<List<User>>( )
            {
            };
            List users = objectMapper.readValue( validUsersFile,
                                                 tr );
            LOGGER.info( "Got users: " + users.size( ) );
            int size = users.size( );
            loginsData = new Object[size][1];
            for( int i = 0; i < size; i++ )
            {
                User user = ( User ) users.get( i );
                LOGGER.info( "Adding user " + user );
                loginsData[i][0] = user;
            }
        } catch( IOException e )
        {
            e.printStackTrace( );
        }

        return loginsData;
    }
}
