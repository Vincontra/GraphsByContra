public class DijikstraBySet {

    // c++ me set bhi we can use instead of PQ
    // reason is to save time which again depends not too much difference in time little bit

    // set stores in ascending order like the min on top and if dis same then node ki val similar to pq

    // if anyone is already visited by some path it is gurantedd that it will have some finite dist
    // and not infinte
    // if so we already have added that to set right
    // and now we got the better or lesser dist
    // so eventually it will simulate on that distance which is added
    // what if we just erase that since we get better we can erase the older one

    // but that erase operation will take logN time

    // so not a big change by using Set but ya we can do so




}
