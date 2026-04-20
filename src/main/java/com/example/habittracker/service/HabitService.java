package com.example.habittracker.service;

import com.example.habittracker.dto.HabitRequest;
import com.example.habittracker.exception.ResourceNotFoundException;
import com.example.habittracker.model.Habit;
import com.example.habittracker.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HabitService {

    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public Habit createHabit(HabitRequest habitRequest) {
        Habit habit = new Habit();
        habit.setName(habitRequest.getName());
        habit.setDescription(habitRequest.getDescription());
        habit.setFrequency(habitRequest.getFrequency());
        habit.setCompleted(habitRequest.isCompleted());

        return habitRepository.save(habit);
    }

    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    public Habit getHabitById(Long id) {
        return habitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found with id: " + id));
    }

    public Habit updateHabit(Long id, HabitRequest habitRequest) {
        Habit habit = getHabitById(id);
        habit.setName(habitRequest.getName());
        habit.setDescription(habitRequest.getDescription());
        habit.setFrequency(habitRequest.getFrequency());
        habit.setCompleted(habitRequest.isCompleted());

        return habitRepository.save(habit);
    }

    public void deleteHabit(Long id) {
        Habit habit = getHabitById(id);
        habitRepository.delete(habit);
    }

    public Map<String, Object> getHabitStats() {
        List<Habit> habits = habitRepository.findAll();
        long totalHabits = habits.size();
        long completedHabits = habits.stream()
                .filter(Habit::isCompleted)
                .count();
        long pendingHabits = totalHabits - completedHabits;
        double completionRate = totalHabits == 0 ? 0.0 : (double) completedHabits / totalHabits * 100;

        Map<String, Object> stats = new HashMap<>();
        stats.put("totalHabits", totalHabits);
        stats.put("completedHabits", completedHabits);
        stats.put("pendingHabits", pendingHabits);
        stats.put("completionRate", completionRate);

        return stats;
    }
}
