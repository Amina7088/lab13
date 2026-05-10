@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    void createMember_success() {
        MemberDTO dto = new MemberDTO();
        dto.setName("Bat");
        dto.setEmail("bat@email.com");
        dto.setPhone("99001234");

        when(memberRepository.findByEmail(any())).thenReturn(Optional.empty());
        when(memberRepository.save(any())).thenReturn(new Member());

        assertNotNull(memberService.createMember(dto));
    }

    @Test
    void createMember_duplicateEmail_throwsException() {
        MemberDTO dto = new MemberDTO();
        dto.setEmail("bat@email.com");

        when(memberRepository.findByEmail("bat@email.com"))
            .thenReturn(Optional.of(new Member()));

        assertThrows(RuntimeException.class,
            () -> memberService.createMember(dto));
    }

    @Test
    void getMemberById_notFound_throwsException() {
        when(memberRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class,
            () -> memberService.getMemberById(99L));
    }
}