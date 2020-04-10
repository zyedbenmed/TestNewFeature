/*------------------------------------------------------------------------------
 -
 - Copyright (c) Created by zied.ben-mohamed on 4/10/20 3:43 PM
 -----------------------------------------------------------------------------*/

package com.example.myapplication

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class MockServerDispatcher {

    class RequestDispatcher : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            return if (request.path == "/posts") {
                MockResponse().setResponseCode(200).setBody("[\n" +
                        "      {\n" +
                        "        \"userId\": 1,\n" +
                        "        \"id\": 1,\n" +
                        "        \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                        "        \"body\": \"YESYES\"\n" +
                        "      }\n" +
                        "    ]")
            } else {
                MockResponse().setResponseCode(200).setBody("[\n" +
                        "      {\n" +
                        "        \"userId\": 1,\n" +
                        "        \"id\": 1,\n" +
                        "        \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                        "        \"body\": \"NONO\"\n" +
                        "      }\n" +
                        "    ]")
            }
        }
    }
}