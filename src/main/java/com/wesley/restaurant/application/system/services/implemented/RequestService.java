package com.wesley.restaurant.application.system.services.implemented;

import com.wesley.restaurant.application.system.entity.Request;
import com.wesley.restaurant.application.system.repository.RequestRepository;
import com.wesley.restaurant.application.system.services.IRequestService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RequestService implements IRequestService {
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Request save(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public Request findById(UUID requestId) {
        return requestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request with ID " + requestId + " not found"));
    }

    @Override
    public void deleteById(UUID requestId) {
        Optional<Request> optionalRequest = requestRepository.findById(requestId);

        if (optionalRequest.isPresent()) {
            Request requestToDelete = optionalRequest.get();
            requestRepository.delete(requestToDelete);
        } else {
            throw new RuntimeException("Request with ID " + requestId + " not found");
        }
    }
}
