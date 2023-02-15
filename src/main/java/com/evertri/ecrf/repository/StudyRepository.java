package com.evertri.ecrf.repository;

import com.evertri.ecrf.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long> {

    Study findByName(String name);
    List<Study> findByNameContaining(String name);
    List<Study> findByDescriptionContaining(String description);

    // Custom methods

    /**
     * Returns a List of all Studies that were created by a specific User.
     *
     * @param userId The id of the User who created the Studies.
     * @return A List of all Studies created by the specified User.
     */
    List<Study> findByUserId(Long userId);

    /**
     * Returns a List of all Studies that have a specific status.
     *
     * @param status The status of the Studies.
     * @return A List of all Studies with the specified status.
     */
    List<Study> findByStatus(String status);

    /**
     * Returns a List of all Studies that were created within a specific date range.
     *
     * @param start The start date of the date range.
     * @param end The end date of the date range.
     * @return A List of all Studies created within the specified date range.
     */
    List<Study> findByCreationDateBetween(String start, String end);

    /**
     * Returns a List of all Studies that contain a specific keyword in either their name or description.
     *
     * @param keyword The keyword to search for in the name and description of the Studies.
     * @return A List of all Studies that contain the specified keyword.
     */
    List<Study> findByNameContainingOrDescriptionContaining(String keyword);
}
