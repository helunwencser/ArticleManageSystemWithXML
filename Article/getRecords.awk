# this is the awk program to get the 
#first 1000 records from dblp.xml
BEGIN{ count=0  }
{
    print $0
    if($0=="</article>")
        ++count;
    if(count==1000){
        print "</dblp>"
        exit 0
    }
}
