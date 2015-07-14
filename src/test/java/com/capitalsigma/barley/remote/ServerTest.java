package com.capitalsigma.barley.remote;

import com.capitalsigma.barley.data.APIResponse;
import com.capitalsigma.barley.data.Submission;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.reporters.Files;
import retrofit.Callback;
import retrofit.RetrofitError;

import java.net.URL;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.testng.Assert.*;

/**
 * Created by patrick on 7/14/15.
 */
public class ServerTest {
    private AtomicInteger testsRunning = new AtomicInteger(0);
    private MockWebServer mockWebServer;

    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("ServerTest.setUp");
        testsRunning.incrementAndGet();
        mockWebServer = new MockWebServer();

    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("ServerTest.tearDown");
        while (testsRunning.get() > 0) {
        // pass
        }
    }

    @Test
    public void testGetFrontPageSubverse() throws Exception {
        System.out.println(
                "this.getClass().getResource(\"\").getPath()\n         = " + this.getClass().getResource("").getPath()
        );
        String mockResponse = Files.readFile(
                this.getClass().getResourceAsStream("src/test/res/TestSubmissions.json"));
        mockWebServer.enqueue(new MockResponse().setBody(mockResponse));
        final APIResponse<List<Submission>> expected = new APIResponse<List<Submission>>();
        mockWebServer.start();


        Server server = new Server("KEEP ME OUT OF VC", mockWebServer.getUrl("/").toString());

        server.getFrontPageSubverse(new Callback<APIResponse<List<Submission>>>() {
            @Override
            public void success(APIResponse<List<Submission>> listResponse, retrofit.client.Response response) {
                System.out.println("listResponse = [" + listResponse + "], response = [" + response + "]");
                assertEquals(expected, listResponse);
                testsRunning.decrementAndGet();
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("error = [" + error + "]");
                assertEquals(0, 1);
                testsRunning.decrementAndGet();
            }
        });
    }

}