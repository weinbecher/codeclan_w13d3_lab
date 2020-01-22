package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	private WhiskyRepository whiskyRepository;
	@Autowired
	private DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getWhiskyByYear() {
		List<Whisky> whiskies = whiskyRepository.findAllByYear(1991);
		assertEquals("The Rosebank 12 - Flora and Fona", whiskies.get(0).getName());
	}

	@Test
	public void getDistilliriesByRegion() {
		List<Distillery> distilleries = distilleryRepository.findAllByRegion("Highland");
		assertEquals("Glendronach", distilleries.get(0).getName());
	}

	@Test
	public void getWhiskiesByDistilleryAndAge() {
		List<Whisky> whiskies = whiskyRepository.findAllByDistilleryIdAndAge(1, 15);
		assertEquals("The Glendronach Revival", whiskies.get(0).getName());
	}

	@Test
	public void getWhiskiesByRegion() {
		List<Whisky> whiskies = whiskyRepository.findAllByDistilleryRegion("Speyside");
		assertEquals("The Macallan Anniversary Malt", whiskies.get(0).getName());
	}
}
