package queuecode;
class Genre
{
	String name;
	int listencount;
	int likecount;
	int commentcount;
	int sharecount;
	Genre(String name, int listencount, int likecount, int commentcount, int sharecount)
	{
		this.name=name;
		this.listencount=listencount;
		this.likecount=likecount;
		this.commentcount=commentcount;
		this.sharecount=sharecount;		
	}
}
