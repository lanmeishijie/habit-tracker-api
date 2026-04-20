package com.example.habittracker.config;

import com.example.habittracker.model.Habit;
import com.example.habittracker.repository.HabitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadSampleData(HabitRepository habitRepository) {
        return args -> {
            if (habitRepository.count() > 0) {
                return;
            }

            Habit habit1 = new Habit();
            habit1.setName("Drink Water");
            habit1.setDescription("Drink 8 glasses of water every day");
            habit1.setFrequency("Daily");
            habit1.setCompleted(false);

            Habit habit2 = new Habit();
            habit2.setName("Exercise");
            habit2.setDescription("Do 30 minutes of exercise");
            habit2.setFrequency("Daily");
            habit2.setCompleted(true);

            Habit habit3 = new Habit();
            habit3.setName("Read Book");
            habit3.setDescription("Read 10 pages of a book");
            habit3.setFrequency("Weekly");
            habit3.setCompleted(false);

            habitRepository.save(habit1);
            habitRepository.save(habit2);
            habitRepository.save(habit3);
        };
    }
}
