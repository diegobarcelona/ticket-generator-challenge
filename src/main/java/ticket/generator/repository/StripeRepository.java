package ticket.generator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ticket.generator.entity.Stripe;

public interface StripeRepository extends JpaRepository<Stripe, Long> {

}
