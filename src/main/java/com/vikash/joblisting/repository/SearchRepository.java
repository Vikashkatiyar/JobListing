package com.vikash.joblisting.repository;
import com.vikash.joblisting.model.*;
import java.util.List;

public interface SearchRepository {
	
   List<Post> findByText(String text);
}
