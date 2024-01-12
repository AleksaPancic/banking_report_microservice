package com.example.bvnk_report_microservice.populator;

public interface Populator<S, T> {

	/**
	 * Populates the target object with values from the source object.
	 *
	 * @param  source  the source object
	 * @param  target  the target object
	 */
	void populate(S source, T target);
}
