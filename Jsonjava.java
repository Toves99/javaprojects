package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
private  static HttpURLConnection connection;
    public static void main(String[] args) throws IOException {
	// method1 java.net.httpConnection
        BufferedReader reader;
        String line;
        StringBuffer respondContent=new StringBuffer();
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/albums");
            connection = (HttpURLConnection) url.openConnection();

            //request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status=connection.getResponseCode();
            System.out.println(status);

            if(status>299)
            {
                reader=new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line=reader.readLine())!=null)
                {
                    respondContent.append(line);
                }
                reader.close();
            }
            else
            {
                reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line=reader.readLine())!=null)
                {
                    respondContent.append(line);
                }
                reader.close();
            }
            //System.out.println(respondContent.toString());
            parse(respondContent.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            connection.disconnect();
        }
    }
    public static String parse(String respondBody){
        JSONArray albums=new JSONArray(respondBody);
        for(int i=0; i<albums.length();i++){
            JSONObject album=albums.getJSONObject(i);
            int id=album.getInt("id");
            int userId=album.getInt("userId");
            String title=album.getString("title");
            System.out.println(id+"  "+userId+"  "+title);

        }
        return null;
    }
}
