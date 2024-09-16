package com.example.demo.service.impl;

import com.example.demo.model.Submission;
import com.example.demo.repository.SubmissionRepository;
import com.example.demo.service.SubmissionService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    @Override
    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    public Submission getSubmissionById(Long id) throws ResourceNotFoundException {
        return submissionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Submission not found with id: " + id));
    }

    @Override
    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    @Override
    public Submission updateSubmission(Long id, Submission submission) throws ResourceNotFoundException {
        if (!submissionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Submission not found with id: " + id);
        }
        submission.setId(id);
        return submissionRepository.save(submission);
    }

    @Override
    public void deleteSubmission(Long id) throws ResourceNotFoundException {
        if (!submissionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Submission not found with id: " + id);
        }
        submissionRepository.deleteById(id);
    }
}
