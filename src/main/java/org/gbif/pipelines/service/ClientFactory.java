package org.gbif.pipelines.service;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ClientFactory {

	public static <S> S createRetrofitClient(String baseApiUrl, Class<S> serviceClass) {
		return new Retrofit.Builder().baseUrl(baseApiUrl).addConverterFactory(JacksonConverterFactory.create())
				.validateEagerly(true).build().create(serviceClass);
	}

	public static void main(String... args) throws Exception {
		DataResourceService dataResourceService = ClientFactory
				.createRetrofitClient("https://collections.ala.org.au/ws/", DataResourceService.class);
		
		Call<DataResourceResponse> call = dataResourceService.get("dr931");
		Response<DataResourceResponse> response = call.execute();
		
		System.out.println(response.body().getLicenseType());
	}
}
