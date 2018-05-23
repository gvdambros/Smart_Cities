package gvdambros.smartCities.RestAPI.builder;

import gvdambros.smartCities.RestAPI.data.ObjectData;

public class ObjectDataBuilder<T> {

	public ObjectData<T> buildSucessful(T data){
		ObjectData<T> objectData = new ObjectData<>();
		objectData.setData(data);
		objectData.setMessage("OK");
		objectData.setStatus(0);
		return objectData;
	}
	
	public ObjectData<?> buildError(Exception e){
		ObjectData<?> objectData = new ObjectData<>();
		objectData.setMessage(e.getMessage());
		objectData.setStatus(1);
		return objectData;
	}
	
}
