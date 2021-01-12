# API for generating vCards

#### API generates .vcf files for contractors based on [panorama firm](https://panoramafirm.pl/)

API creates list of companies for requested service from user. Shows data in fixed data. Each rows contains standard information about contractor like: Name, Telephone number, EMail, Url to site(if exists), Address, and in the last column there is a button to download the vCard file.

#### How to run:
Run `Lab4Application.java`  


Type:
``` 
http://localhost:8080/getSite?service=SERVICE
```
where SERVICE is required name of service that You want to find contractors.



### Example:
Input:
``` 
http://localhost:8080/getSite?service=hydraulik
```

Output:
[Example site](https://rahano.github.io/githubPages/Example.html)
[Example vcf file](https://rahano.github.io/githubPages/VCard1.vcf)
