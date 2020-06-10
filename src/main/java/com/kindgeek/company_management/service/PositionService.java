package com.kindgeek.company_management.service;

        import com.kindgeek.company_management.entity.Position;
        import com.kindgeek.company_management.repository.PositionRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.Optional;


@Service
public class PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Position addPosition(Position position) {
        return positionRepository.save(position);
    }

    public Iterable<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public Optional<Position> getPositionById(Long id) {
        return positionRepository.findById(id);
    }

    public void deletePosition(Long id) {
        positionRepository.deleteById(id);
    }

    public Position updatePosition(Long id, Position newPosition) {
        return positionRepository.findById(id)
                .map(position -> {
                    String proficiency = newPosition.getProficiency();
                    String technology = newPosition.getTechnology();
                    if (proficiency != null) position.setProficiency(proficiency);
                    if (technology != null) position.setTechnology(technology);
                    return positionRepository.save(position);
                })
                .orElseGet(() -> {
                    newPosition.setPositionId(id);
                    return positionRepository.save(newPosition);
                });
    }


}
