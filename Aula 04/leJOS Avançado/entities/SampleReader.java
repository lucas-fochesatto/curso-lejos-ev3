package entities;

import lejos.robotics.SampleProvider;

public class SampleReader {
	public static float[] getSampleArray(SampleProvider sensorMode) {
		// declaração do vetor de samples
		float[] sampleArray = new float[sensorMode.sampleSize()];
	
		// realizar a leitura e armazenar a partir da posição zero do vetor
		sensorMode.fetchSample(sampleArray, 0);
		
		return sampleArray;
	}
}