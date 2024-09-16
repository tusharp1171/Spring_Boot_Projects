package com.example.demo.service;

import com.example.demo.model.Submission;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface SubmissionService {
    Submission createSubmission(Submission submission);
    Submission getSubmissionById(Long id) throws ResourceNotFoundException;
    List<Submission> getAllSubmissions();
    Submission updateSubmission(Long id, Submission submission) throws ResourceNotFoundException;
    void deleteSubmission(Long id) throws ResourceNotFoundException;
}
