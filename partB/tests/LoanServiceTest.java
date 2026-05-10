@ExtendWith(MockitoExtension.class)
class LoanServiceTest {
    @Mock private LoanRepository loanRepository;
    @Mock private BookRepository bookRepository;
    @Mock private MemberRepository memberRepository;

    @InjectMocks
    private LoanService loanService;

    @Test
    void createLoan_bookNotAvailable_throwsException() {
        Book book = new Book();
        book.setAvailable(false);

        LoanDTO dto = new LoanDTO();
        dto.setBookId(1L);
        dto.setMemberId(1L);
        dto.setDueDate(LocalDate.now().plusDays(7));

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        assertThrows(RuntimeException.class,
            () -> loanService.createLoan(dto));
    }

    @Test
    void returnBook_alreadyReturned_throwsException() {
        Loan loan = new Loan();
        loan.setReturned(true);

        when(loanRepository.findById(1L)).thenReturn(Optional.of(loan));

        assertThrows(RuntimeException.class,
            () -> loanService.returnBook(1L));
    }

    @Test
    void getOverdueLoans_returnsOverdue() {
        when(loanRepository.findByReturnedFalseAndDueDateBefore(any()))
            .thenReturn(List.of(new Loan(), new Loan()));

        assertEquals(2, loanService.getOverdueLoans().size());
    }

    @Test
    void createLoan_success() {
        Book book = new Book();
        book.setAvailable(true);

        Member member = new Member();

        LoanDTO dto = new LoanDTO();
        dto.setBookId(1L);
        dto.setMemberId(1L);
        dto.setDueDate(LocalDate.now().plusDays(7));

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        when(loanRepository.save(any())).thenReturn(new Loan());

        assertNotNull(loanService.createLoan(dto));
    }
}