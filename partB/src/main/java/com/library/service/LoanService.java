package com.library.service;

import com.library.dto.LoanDTO;
import com.library.entity.*;
import com.library.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public LoanService(LoanRepository loanRepository, 
                   BookRepository bookRepository, 
                   MemberRepository memberRepository) {
            this.loanRepository = loanRepository;
            this.bookRepository = bookRepository;
            this.memberRepository = memberRepository;
        }

    public Loan createLoan(LoanDTO dto) {
        Book book = bookRepository.findById(dto.getBookId())
            .orElseThrow(() -> new RuntimeException("Book not found"));

        if (!book.isAvailable()) {
            throw new RuntimeException("Book is not available");
        }

        Member member = memberRepository.findById(dto.getMemberId())
            .orElseThrow(() -> new RuntimeException("Member not found"));

        book.setAvailable(false);
        bookRepository.save(book);

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setMember(member);
        loan.setDueDate(dto.getDueDate());
        return loanRepository.save(loan);
    }

    public Loan returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
            .orElseThrow(() -> new RuntimeException("Loan not found"));

        if (loan.isReturned()) {
            throw new RuntimeException("Book already returned");
        }

        loan.setReturned(true);
        loan.setReturnDate(LocalDate.now());

        Book book = loan.getBook();
        book.setAvailable(true);
        bookRepository.save(book);

        return loanRepository.save(loan);
    }

    public List<Loan> getOverdueLoans() {
        return loanRepository.findByReturnedFalseAndDueDateBefore(LocalDate.now());
    }

    public List<Loan> getLoansByMember(Long memberId) {
        return loanRepository.findByMemberId(memberId);
    }
}