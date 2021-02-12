package io.starter.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	 List<Topic> topics =
				new ArrayList<>(Arrays.asList(
						new Topic("spring", "Spring Framework", "Spring Framework description"),
						new Topic("java", "Core Java", "Core Java description"),
						new Topic("javascript", "Javascript", "Javascript description")		
					));

	 public List<Topic> getAllTopics(){
		 return topics;
	 }
	 
	 //using lambda expression to iterate through topics list and find id and return it.
	 public Topic getTopic(String id) {
		  return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	 }

	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		for(int i =0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
	}
}
 