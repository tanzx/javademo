@Component
public class FatherFactory{
    private SonRepository sonRepo;
    @Autowired
    public FatherFactory(SonRepository sonRepo){}
    public BetterFather createFather(){
        return new BetterFather(sonRepo);
    }
}
