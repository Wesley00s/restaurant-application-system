package com.wesley.restaurant.application.system.services.implemented;

import com.wesley.restaurant.application.system.entity.*;
import com.wesley.restaurant.application.system.repository.*;
import com.wesley.restaurant.application.system.services.IRequestService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RequestService implements IRequestService {
    private final RequestRepository requestRepository;
    private final ItemRepository itemRepository;
    private final EatingTableRepository eatingTableRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;


    public RequestService(RequestRepository requestRepository, ItemRepository itemRepository, EatingTableRepository eatingTableRepository, ClientRepository clientRepository, EmployeeRepository employeeRepository) {
        this.requestRepository = requestRepository;
        this.itemRepository = itemRepository;
        this.eatingTableRepository = eatingTableRepository;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
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

//    @Override
//    public Request requestItem(Long clientId, Long itemId, Long eatingTableId, Long employeeId) {
//       Optional<Client> clientOptional = clientRepository.findById(clientId);
//       Optional<Item> itemOptional = itemRepository.findById(itemId);
//       Optional<EatingTable> eatingTableOptional = eatingTableRepository.findById(eatingTableId);
//       Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
//
//       if (clientOptional.isPresent()
//            && itemOptional.isPresent()
//            && eatingTableOptional.isPresent()
//            && employeeOptional.isPresent()
//       ) {
//           Client client = clientOptional.get();
//           Item item = itemOptional.get();
//           EatingTable eatingTable = eatingTableOptional.get();
//           Employee employee = employeeOptional.get();
//           return requestRepository.save(new Request(client, item, eatingTable, employee));
//       } else {
//           throw new IllegalArgumentException("Unable to create Request. Some entity was not found.");
//       }
//    }
}
