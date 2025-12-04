package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Product;
import com.example.demo.entities.Review;
import com.example.demo.entities.User;
import com.example.demo.repos.ProductRepository;
import com.example.demo.repos.ReviewRepository;
import com.example.demo.repos.UserRepository;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin("*")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private UserRepository userRepo;

    // 1) Add Review
    @PostMapping("/add")
    public Review addReview(@RequestParam Long productId,
                            @RequestParam Long customerId,
                            @RequestBody Review review) {

        Product p = productRepo.findById(productId).orElse(null);
        User c = userRepo.findById(customerId).orElse(null);

        if (p == null || c == null) {
            return null; // किंवा इथे proper error response देऊ शकतोस
        }

        review.setProduct(p);
        review.setCustomer(c);
        review.setStatus(false); // default unapproved

        return reviewRepo.save(review);
    }

    // 2) Get all reviews
    @GetMapping
    public List<Review> getAll() {
        return reviewRepo.findAll();
    }

    // 3) Get reviews by product
    @GetMapping("/product/{productId}")
    public List<Review> getByProduct(@PathVariable Integer productId) {
        return reviewRepo.findByProductId(productId);
    }

    // 4) Approve review
    @PutMapping("/approve/{id}")
    public Review approve(@PathVariable Integer id) {
        Review r = reviewRepo.findById(id).orElse(null);
        if (r == null) return null;

        r.setStatus(true);
        return reviewRepo.save(r);
    }

    // 5) Delete review
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        reviewRepo.deleteById(id);
    }
}
