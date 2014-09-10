package utils;

import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Initial extends Job{
	public void doJob() {
		DatabaseUtil.init();
    }
}
