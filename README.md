`gen-csv`
=========

A Clojure utility for generating "random" CSV files.

  * Data generated using [clojure.data.generators](https://github.com/clojure/data.generators)
  * Time formatted with [clj-time](https://github.com/clj-time/clj-time)

Usage
-----

### Write 10 randomly generated CSV rows


```bash
lein run example.edn
```

#### Example config in `example.edn`

```clojure
{
  :data [
    (gen/uuid)
    (+ 40 (rand-int 60))
    (gen/date)
    (gen/one-of "a" "b" "c" "d")
    (gen/boolean)
    (gen/short)
    (gen/int)
    (gen/long)
    (gen/string)
    (gen/long)
    10
  ]
  :output-file "hello.csv"
  :lines 10
}
```

#### Example output in `example.csv`

```csv
ba419d35-0dfe-8af7-aee7-bbe10c45c028,72,Sun Jun 01 04:11:11 EDT 2014,2013-07-02T11:30:32.479Z,c,true,-26783,-209348649,7040072382879853816,h~.Ixk.@7B/:]'(k>2,204137701428793873,10
c5004374-f95a-6723-14a5-c4b5b6a1caca,65,Mon Oct 11 14:26:33 EDT 1993,2013-07-22T04:19:32.493Z,a,false,29482,1376501900,-6702724865295600521,"BIKLLn.oK:21rNG\b=VCrlZCbv2l[L=S\+O""#M^EyD]itX|'i",5143363558960181380,10
e632520a-2e4f-3419-5fb3-b9bceba6e693,87,Thu Oct 11 17:26:09 EDT 2001,2013-07-29T10:36:32.497Z,c,false,19394,-1608997690,7314533619882679792,v;y<^,4683776719285265827,10
67ac6cf8-f7ad-c5f4-fc3c-f927e78d61eb,89,Wed Jan 16 00:43:23 EDT 1974,2013-07-28T09:32:32.501Z,b,false,20289,92317331,-3040843324269085054,aT*Wu[Duo8{EV8n^ZNBfq@hdPi,6937585892084774728,10
dce20b69-20f0-bd7e-b274-b53d66eb0cfe,93,Tue Mar 22 16:38:28 EDT 2039,2013-08-20T11:07:32.504Z,a,true,-4405,1137404660,-6593468707804271306,"R7#.Xfg|u[JQEK1aIK,.{C :R{%9@Y7!;?^\M4n9K*",-1058645583583936664,10
cedbf96b-a577-5c53-8ae5-e37bd71037eb,91,Sat Nov 25 04:16:28 EST 1989,2013-07-18T13:21:32.507Z,c,false,7433,370718376,2971056645043808722,,-7572858850093070837,10
c779d3fe-6ed6-1c78-8479-88f99c82aac5,46,Wed Jan 11 14:07:27 EST 2068,2013-07-29T04:19:32.512Z,c,false,13395,613544044,8579123651018726797,L|*5!K,-3324884956682660132,10
a4688e1e-56c6-3f3f-f7e7-07100a7ebdbd,44,Tue Oct 13 01:03:38 EDT 2015,2013-07-27T03:15:32.516Z,d,false,-12866,598941085,-8009235629634042951,"R9/bEK9MGW/8P7\@^m}Pz9]yXf,a-S&d",-5985525436487507050,10
d70173c0-1519-0d55-7b04-ab9756cf7cc3,79,Sun Jun 12 14:33:33 EDT 2011,2013-09-10T20:22:32.520Z,a,true,31271,1778736097,8491964968156714474,=T^G0,3473164520662945660,10
7461d0ff-6bb0-07ba-8692-065599d263f8,49,Mon May 28 06:53:51 EDT 1973,2013-09-09T18:44:32.524Z,d,true,8051,-1405766164,7930252083276292976,"E&)w3UU'GU)Zw#1~f&>\e""mDpPm}T!.,`awFsx-K.f9#sRt""K=.[K`VZccQa73W[sS|-?p_<6k]>0D]_Y4g^2 1J3U-.lHU;u%EMtN?F $zI-#X:5fP%\P}n*WfUQ@h_6[ryo9Vz dnv",-4033711210325971391,10
```


### Create other config files based on example.edn

License
-------

Copyright © 2013 Olivier Lauzon

Distributed under the Eclipse Public License.
