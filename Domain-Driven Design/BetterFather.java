public class BetterFather{
    //private Son son; 删除这个引用
    private SonRepository sonRepo;// 添加一个 Son 的 repo
    private getSon(){return sonRepo.getByFatherId(this.id);}
}
